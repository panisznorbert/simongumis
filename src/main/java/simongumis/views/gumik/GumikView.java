package simongumis.views.gumik;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_GUMIK, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_GUMIK)
public class GumikView extends AppLayout {
}
