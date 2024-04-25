package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.impl.CustomerServiceImpl;
import com.javaweb.service.impl.UserService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageUtils messageUtil;
    @Autowired
    private ICustomerRepository customerRepository;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView getCustomer(@ModelAttribute(SystemConstant.MODEL) CustomerSearchRequest model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("staffs", userService.getListStaff());
        mav.addObject("modelSearch", model);
        DisplayTagUtils.of(request, model);
        PageRequest pageRequest = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
        List<CustomerDTO> result = customerService.findAll(pageRequest);
        model.setListResult(result);
        model.setTotalItems(customerService.countTotalCustomer());
        mav.addObject("customers", result);
        initMessageResponse(mav, request);
        return mav;
    }

    @GetMapping(value = "/admin/customer-edit")
    public ModelAndView addCustomer(@ModelAttribute("customerEdit") CustomerDTO customerDTO) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit-{id}", method = RequestMethod.GET)
    public ModelAndView updateCustomer(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("staffs", userService.getListStaff());
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity = customerService.findById(id);
        mav.addObject("customerEdit", customerEntity);
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }

}
