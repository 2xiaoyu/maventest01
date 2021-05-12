package com.smbms.controller;

import com.smbms.entity.Provider;
import com.smbms.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Model model) {
        List<Provider> list = providerService.getall();
        return list;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable Integer id, Model model) {
        Provider provider = providerService.getById(id);
        model.addAttribute("view", provider);
        return "provider/provider_view.jsp";
    }

    @RequestMapping(value = "/add")
    public String add(Provider provider, Model model) throws SQLException {
        int add = providerService.add(provider);
        return getall(model);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getall(Model model) {
        List<Provider> list = providerService.getall();
        model.addAttribute("providerList", list);
        return "providerlist";
    }
}
