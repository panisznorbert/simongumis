package simongumis.views.rendelesek;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;

@Route(layout = MainView.class)
@RouteAlias(value = "rendelesek", layout = MainView.class)
@PageTitle("Rendelések")
public class RendelesekView  extends AppLayout {
}
