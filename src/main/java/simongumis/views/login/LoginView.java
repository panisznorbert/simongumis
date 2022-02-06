package simongumis.views.login;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "login")
@PageTitle("Simong Gumis")
public class LoginView extends HorizontalLayout {


    public LoginView(){

        LoginForm loginForm = new LoginForm();

        loginForm.setI18n(loginViewSetting());
        loginForm.setAction("login");
        add(loginForm);
    }

    private LoginI18n loginViewSetting(){

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Simon Gumis");
        i18n.setAdditionalInformation(null);
        i18n.setForm(new LoginI18n.Form());
        i18n.getForm().setSubmit("Belépés");
        i18n.getForm().setTitle("Belépés");
        i18n.getForm().setUsername("Felhasználónév");
        i18n.getForm().setPassword("Jelszó");

        return i18n;
    }

}
