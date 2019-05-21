package com.sliit.paf.payment.service.custom.impl;

import com.sliit.paf.payment.dto.PaymentDTO;
import com.sliit.paf.payment.repository.custom.OrderRepository;
import com.sliit.paf.payment.repository.custom.PaymentRepository;
import com.sliit.paf.payment.service.Converter;
import com.sliit.paf.payment.service.custom.ManagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManagePaymentServiceImpl implements ManagePaymentService {

    private PaymentRepository paymentDAO;

    @Autowired
    public ManagePaymentServiceImpl(PaymentRepository customerDAO) {
        this.paymentDAO = customerDAO;
    }

    @Transactional(readOnly = true)
    public List<PaymentDTO> getPayments() {

<<<<<<< HEAD
        return paymentDAO.findAll().map(Converter::<PaymentDTO>getDTOList).get();

=======
        paymentDAO.findAll().map(Converter::<PaymentDTO>getDTOList).get();
        return null;
>>>>>>> 5c35b5fc327969351e322200788d774367c82e28
    }

    public void createPayment(PaymentDTO dto) {

        paymentDAO.save(Converter.getEntity(dto));
    }

    public void updatePayment(PaymentDTO dto) {
        paymentDAO.update(Converter.getEntity(dto));
    }

    public void deletePayment(String odrerID) {
        paymentDAO.delete(odrerID);
    }

    public PaymentDTO findPayment(String id) {
        return paymentDAO.find(id).map(Converter::<PaymentDTO>getDTO).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<PaymentDTO> findEachPayment(String cid) {
        return paymentDAO.findEach(cid).map(Converter::<PaymentDTO>getDTOList).get();
    }

}
