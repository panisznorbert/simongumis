package simongumis.views.beallitasok;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;

@Route(layout = MainView.class)
@RouteAlias(value = "beallitasok", layout = MainView.class)
@PageTitle("Beállítások")
public class BeallitasokView  extends AppLayout {
}
