package com.saml.okta.controller;

import com.saml.okta.model.PreAuthUsername;
import com.saml.okta.utils.SamlOktaConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * "Pre-auth" landing page in which the user will enter their username. Depending on
 * the username suffix, the user will either be directed to provide a password for
 * database authentication, or the SAML auth flow will be initiated.
 *
 * The redirect to /doSaml will be picked up by the custom auth entry point defined
 * in {@link com.saml.okta.config.WebSecurityConfig}.
 *
 * @author rohangupta
 */

@Controller
public class IndexController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("username", new PreAuthUsername());
        return "index";
    }

    @PostMapping("/pre-auth")
    public String preAuth(@ModelAttribute PreAuthUsername username,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        if (StringUtils.endsWithIgnoreCase(username.getUsername(), SamlOktaConstants.OKTA_USERNAME_SUFFIX)) {
            // redirect to SAML
            return "redirect:/doSaml";
        } else if (StringUtils.endsWithIgnoreCase(username.getUsername(), SamlOktaConstants.DB_USERNAME_SUFFIX)) {
            // redirect to DB/form login
            return "redirect:/form-login?username="+username.getUsername();
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid Username");
            return "redirect:/";
        }
    }
}
