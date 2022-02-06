package simongumis.views.login;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.*;
import simongumis.security.SecurityUtils;
import simongumis.views.kezdolap.KezdolapView;
import simongumis.views.utils.SimonGumisConst;


@Route(value = SimonGumisConst.PAGE_LOGIN)
@JsModule("./styles/shared-styles.js")
@PageTitle(SimonGumisConst.TITLE_LOGIN)
public class LoginView extends LoginOverlay implements AfterNavigationObserver, BeforeEnterObserver{

    public LoginView() {
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Simon Gumis");
        i18n.setAdditionalInformation(null);
        i18n.setForm(new LoginI18n.Form());
        i18n.getForm().setSubmit("Belépés");
        i18n.getForm().setTitle("Belépés");
        i18n.getForm().setUsername("Felhasználónév");
        i18n.getForm().setPassword("Jelszó");
        setI18n(i18n);
        setForgotPasswordButtonVisible(false);
        setAction("login");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (SecurityUtils.isUserLoggedIn()) {
            event.forwardTo(KezdolapView.class);
        } else {
            setOpened(true);
        }
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        setError(
                event.getLocation().getQueryParameters().getParameters().containsKey(
                        "error"));
    }


}
