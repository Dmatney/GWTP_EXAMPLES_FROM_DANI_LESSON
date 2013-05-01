package Apple.King.client.gin;

import Apple.King.client.FirstPresenter;
import Apple.King.client.SecondPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import Apple.King.client.HeaderPresenter;
import Apple.King.client.TestGatekeeper;
import Apple.King.client.ThirdPresenter;
import Apple.King.client.ErrorPresenter;
import Apple.King.client.place.LoginPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	Provider<FirstPresenter> getFirstPresenter();

	AsyncProvider<SecondPresenter> getSecondPresenter();

	AsyncProvider<HeaderPresenter> getHeaderPresenter();

	AsyncProvider<ThirdPresenter> getThirdPresenter();

	AsyncProvider<ErrorPresenter> getErrorPresenter();
	
	TestGatekeeper getTestGatekeeper();

	AsyncProvider<LoginPresenter> getLoginPresenter();
}
