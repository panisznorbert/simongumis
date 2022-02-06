package simongumis.views.gumik;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;

@Route(layout = MainView.class)
@RouteAlias(value = "gumik", layout = MainView.class)
@PageTitle("Gumik")
public class GumikView extends AppLayout {
}
