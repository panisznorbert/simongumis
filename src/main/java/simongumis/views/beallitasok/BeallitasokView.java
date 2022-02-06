package simongumis.views.beallitasok;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;
import simongumis.views.utils.SimonGumisConst;

@Route(layout = MainView.class)
@RouteAlias(value = SimonGumisConst.PAGE_BEALLITASOK, layout = MainView.class)
@PageTitle(SimonGumisConst.TITLE_BEALLITASOK)
public class BeallitasokView  extends AppLayout {
}
