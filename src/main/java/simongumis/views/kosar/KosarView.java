package simongumis.views.kosar;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;

@Route(layout = MainView.class)
@RouteAlias(value = "kosar", layout = MainView.class)
@PageTitle("Kosár")
public class KosarView extends AppLayout {
}
