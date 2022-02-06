package simongumis.views.lefolglalt_idopontok;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_LEFOGLALT_IDOPONTOK, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_LEFOGLALT_IDOPONTOK)
public class LefoglaltIdopontokView extends AppLayout {
}
