package simongumis.views.lefolglalt_idopontok;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import simongumis.views.MainView;

@Route(layout = MainView.class)
@RouteAlias(value = "lefoglaltIdopntok", layout = MainView.class)
@PageTitle("Lefoglalt időpontok")
public class LefoglaltIdopontokView extends AppLayout {
}
