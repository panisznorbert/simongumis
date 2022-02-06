package simongumis.views.idopontfoglalas;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_IDOPONTFOGLALAS, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_IDOPONTFOGLALAS)
public class IdopontfoglalasView extends AppLayout {
}
