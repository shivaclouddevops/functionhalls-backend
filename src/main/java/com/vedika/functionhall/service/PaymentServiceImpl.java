package com.vedika.functionhall.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.BookingSlot;
import com.vedika.functionhall.model.Payment;
import com.vedika.functionhall.model.PaymentCallback;
import com.vedika.functionhall.model.PaymentDetail;
import com.vedika.functionhall.model.PaymentInfo;
import com.vedika.functionhall.model.PaymentStatus;
import com.vedika.functionhall.repository.BookingRepo;
import com.vedika.functionhall.repository.PaymentRepo;
import com.vedika.functionhall.util.PaymentUtil;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepository;
	@Autowired
	private BookingRepo bookingrepo;

	@Override
	public PaymentDetail proceedPayment(PaymentDetail paymentDetail) {
		PaymentUtil paymentUtil = new PaymentUtil();
		paymentDetail = paymentUtil.populatePaymentDetail(paymentDetail);
		savePaymentDetail(paymentDetail);
		return paymentDetail;
	}

	@Override
	public String payuCallback(PaymentInfo paymentinfo, BookingSlot bookingslot) {
		String msg = "Transaction failed.";
		Payment payment = paymentRepository.findByTxnId(paymentinfo.getTxnid());
		if (payment != null) {
			// TODO validate the hash
			PaymentStatus paymentStatus = null;
			if (paymentinfo.getStatus().equals("failure")) {
				paymentStatus = PaymentStatus.Failed;
			} else if (paymentinfo.getStatus().equals("success")) {
				paymentStatus = PaymentStatus.Success;
				msg = "Transaction success";
				payment.setFunctionhallId(paymentinfo.getFunctionhallId());
				payment.setPaymentStatus(paymentStatus);
				payment.setMihpayId(paymentinfo.getMihpayid());
				payment.setMode(paymentinfo.getMode());
				bookingslot.setDate(paymentinfo.getDate());
				paymentRepository.save(payment);
				bookingrepo.save(bookingslot);
			}

		}
		return msg;
	}

	private void savePaymentDetail(PaymentDetail paymentDetail) {
		Payment payment = new Payment();
		payment.setAmount(Double.parseDouble(paymentDetail.getAmount()));
		payment.setEmail(paymentDetail.getEmail());
		payment.setName(paymentDetail.getName());
		payment.setPaymentDate(new Date());
		payment.setPaymentStatus(PaymentStatus.Pending);
		payment.setPhone(paymentDetail.getPhone());
		payment.setProductInfo(paymentDetail.getProductInfo());
		payment.setTxnId(paymentDetail.getTxnId());
		paymentRepository.save(payment);
	}

}
