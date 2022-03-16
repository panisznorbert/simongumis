package simongumis.views.idopontfoglalas;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simongumis.services.IdopontfoglalasService;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_IDOPONTFOGLALAS, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_IDOPONTFOGLALAS)
@UIScope
@SpringComponent
public class IdopontfoglalasView extends HorizontalLayout {

    private final static Logger LOGGER = Logger.getLogger(IdopontfoglalasView.class.getName());

    @Autowired
    IdopontfoglalasService idopontfoglalasService;

    public  IdopontfoglalasView(IdopontfoglalasService idopontfoglalasService){
        FoglalasCalendar calendar = new FoglalasCalendar(idopontfoglalasService);
        add(calendar);
    }
}
