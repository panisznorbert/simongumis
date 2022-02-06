package simongumis.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import simongumis.security.SecurityUtils;
import simongumis.views.beallitasok.BeallitasokView;
import simongumis.views.gumik.GumikView;
import simongumis.views.idopontfoglalas.IdopontfoglalasView;
import simongumis.views.kezdolap.KezdolapView;
import simongumis.views.kosar.KosarView;
import simongumis.views.lefolglalt_idopontok.LefoglaltIdopontokView;
import simongumis.views.rendelesek.RendelesekView;
import simongumis.views.utils.SimonGumisConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@PWA(name = "Simon Gumis", shortName = "Simon Gumis")
public class MainView extends AppLayout {
    private Tabs menu;

    public MainView() {

        this.setDrawerOpened(false);
        Span appName = new Span("Simon Gumis");
        appName.addClassName("hide-on-mobile");

        menu = menuOsszeallitasa();

        this.addToNavbar(appName);
        this.addToNavbar(true, menu);

        getElement().addEventListener("search-focus", e -> {
            getElement().getClassList().add("hide-navbar");
        });

        getElement().addEventListener("search-blur", e -> {
            getElement().getClassList().remove("hide-navbar");
        });
    }

    private static Tabs menuOsszeallitasa() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);

        tabs.add(elerhetoMenupontok());
        return tabs;
    }

    private static Tab[] elerhetoMenupontok() {
        final List<Tab> tabs = new ArrayList<>(4);

        tabs.add(menupontFelvetele(VaadinIcon.HOME, SimonGumisConst.MENU_TITLE_KEZDOLAP, KezdolapView.class));
        tabs.add(menupontFelvetele(VaadinIcon.DOT_CIRCLE, SimonGumisConst.MENU_TITLE_GUMIK, GumikView.class));
        tabs.add(menupontFelvetele(VaadinIcon.CALENDAR, SimonGumisConst.MENU_TITLE_IDOPONTFOGLALAS, IdopontfoglalasView.class));
        tabs.add(menupontFelvetele(VaadinIcon.CART_O, SimonGumisConst.MENU_TITLE_KOSAR, KosarView.class));

        if (SecurityUtils.isUserLoggedIn()) {

            tabs.add(menupontFelvetele(VaadinIcon.CALENDAR_USER, SimonGumisConst.MENU_TITLE_LEFOGLALT_IDOPONTOK, LefoglaltIdopontokView.class));
            tabs.add(menupontFelvetele(VaadinIcon.BOOK_DOLLAR, SimonGumisConst.MENU_TITLE_RENDELESEK, RendelesekView.class));
            tabs.add(menupontFelvetele(VaadinIcon.COGS, SimonGumisConst.MENU_TITLE_BEALLITASOK, BeallitasokView.class));
        }


        return tabs.toArray(new Tab[tabs.size()]);
    }
    private static Tab menupontFelvetele(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return menupontFelvetele(populateLink(new RouterLink(null, viewClass), icon, title));
    }

    private static Tab menupontFelvetele(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();

        RouteConfiguration configuration = RouteConfiguration.forSessionScope();
        if (configuration.isRouteRegistered(this.getContent().getClass())) {
            String target = configuration.getUrl(this.getContent().getClass());
            Optional< Component > tabToSelect = menu.getChildren().filter(tab -> {
                Component child = tab.getChildren().findFirst().get();
                return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
            }).findFirst();
            tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
        } else {
            menu.setSelectedTab(null);
        }
    }
}
