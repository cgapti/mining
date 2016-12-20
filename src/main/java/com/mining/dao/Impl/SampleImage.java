package com.mining.dao.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mining.exception.MiningException;
import com.mining.model.StoneImage;

public class SampleImage {

	@Autowired
	private static SessionFactory sessionFactory;

	public static void main(String[] args) throws MiningException {
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			// save image into database
			File file = new File("D:\\sample.gif");
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
			StoneImage stoneImage = new StoneImage();
			stoneImage.setImage(bFile);
			session.save(stoneImage);
			// Get image from database
			StoneImage stoneImage2 = (StoneImage) session.get(StoneImage.class,
					stoneImage.getImageID());
			byte[] bAvatar = stoneImage2.getImage();
			FileOutputStream fos = new FileOutputStream("D:\\test.gif");
			fos.write(bAvatar);
			fos.close();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new MiningException("Error occured:", e.getMessage());
		}
	}

	private static Session getSession() throws MiningException {
		Session session = sessionFactory.getCurrentSession();
		if (null == session) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
