package simongumis.views.idopontfoglalas;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;

@Route(layout = MainView.class)
@RouteAlias(value = "idopontfoglalas", layout = MainView.class)
@PageTitle("Időpontfoglalás")
public class IdopontfoglalasView extends AppLayout {
}
