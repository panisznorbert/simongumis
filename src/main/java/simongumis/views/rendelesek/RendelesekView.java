package simongumis.views.rendelesek;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_RENDELESEK, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_RENDELESEK)
public class RendelesekView  extends AppLayout {
}
