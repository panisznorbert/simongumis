package simongumis.views.kezdolap;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

@Tag("Kezdolap-view")
@JsModule("./src/views/kezdolap/kezdolap-view.js")
@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_ROOT, layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_KEZDOLAP, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_KEZDOLAP)
public class KezdolapView extends VerticalLayout {


    public KezdolapView(){

        DrawerToggle toggle = new DrawerToggle();

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroup.setLabel("Travel class");
        radioGroup.setItems("Economy", "Business", "First Class");

        add(radioGroup);
    }



}
