package Apple.King.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.shared.ActionImpl;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.server.guice.HttpSessionSecurityCookieFilter;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		serve("/" + ActionImpl.DEFAULT_SERVICE_NAME).with(DispatchServiceImpl.class);
		//serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);
		//bindConstant().annotatedWith(SecurityCookie.class).to("MYCOOKIE");
		//filter("*.html").through( HttpSessionSecurityCookieFilter.class );
	}
}
