package Apple.King.server.guice;

import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.Injector;
import com.google.inject.Guice;
import Apple.King.server.guice.ServerModule;
import Apple.King.server.guice.DispatchServletModule;

public class GuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice
				.createInjector(new ServerModule(), new DispatchServletModule());
	}
}
