package com.sliit.paf.payment.service.custom;

import com.sliit.paf.payment.dto.PaymentDTO;
import com.sliit.paf.payment.service.SuperService;

import java.util.List;

public interface ManagePaymentService extends SuperService {

    List<PaymentDTO> getPayments();

    void createPayment(PaymentDTO dto);

    void updatePayment(PaymentDTO dto);

    void deletePayment(String odrerID);

    PaymentDTO findPayment(String id);

}
