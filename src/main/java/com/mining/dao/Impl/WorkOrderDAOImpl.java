package com.mining.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.WorkOrderDAO;
import com.mining.exception.MiningException;
import com.mining.model.WorkOrder;
import com.mining.model.JSON.WorkOrderInfo;
import com.mining.util.MiningConstants;

@Repository("workOrderDAOImpl")
public class WorkOrderDAOImpl extends AbstractDao<Integer, WorkOrder> implements
		WorkOrderDAO {
	
	final static Logger logger = LoggerFactory
			.getLogger(WorkOrderDAOImpl.class);
	/**
	 * saveWorkOrder
	 * 
	 */
	public String saveWorkOrder(WorkOrder workOrder) throws MiningException {
		logger.debug("saveWorkOrder method starts");
		saveOrUpdate(workOrder);
		logger.debug("saveWorkOrder method ends");
		return MiningConstants.success;
	}
	
	@SuppressWarnings("unchecked")
	public List<WorkOrderInfo> getWorkOrderDetails() throws MiningException {
		logger.debug("getWorkOrderDetails method starts");
		List<WorkOrderInfo> woList = new ArrayList<WorkOrderInfo>();
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from WorkOrder");
			List<WorkOrder> Querylist = query.list();
			if(null != Querylist) {
				for(WorkOrder workOrder : Querylist) {
					WorkOrderInfo workOrderInfo = new WorkOrderInfo();
					workOrderInfo.setEmpName(workOrder.getEmpName());
					workOrderInfo.setTimeIN(workOrder.getTimeIN());
					workOrderInfo.setTimeOUT(workOrder.getTimeOUT());
					workOrderInfo.setWorkedHours(workOrder.getWorkedHours());
					woList.add(workOrderInfo);
				}
			}			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("getWorkOrderDetails method ends");
		return woList;
	}

}
