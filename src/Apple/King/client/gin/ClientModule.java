package Apple.King.client.gin;

import Apple.King.client.ErrorPresenter;
import Apple.King.client.ErrorView;
import Apple.King.client.FirstPresenter;
import Apple.King.client.FirstView;
import Apple.King.client.HeaderPresenter;
import Apple.King.client.HeaderView;
import Apple.King.client.RatePagePresenter;
import Apple.King.client.RatePageView;
import Apple.King.client.SecondPresenter;
import Apple.King.client.SecondView;
import Apple.King.client.ThirdPresenter;
import Apple.King.client.ThirdView;
import Apple.King.client.WhyNotPresenter;
import Apple.King.client.WhyNotView;
import Apple.King.client.place.ClientPlaceManager;
import Apple.King.client.place.DefaultPlace;
import Apple.King.client.place.LoginPresenter;
import Apple.King.client.place.LoginView;
import Apple.King.client.place.NameTokens;

import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(FirstPresenter.class, FirstPresenter.MyView.class,
				FirstView.class, FirstPresenter.MyProxy.class);
		
		//Is NOT a secret
		bindConstant().annotatedWith(SecurityCookie.class).to("MYCOOKIE");
	

		//This is where you set which page displays first
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.first);

		bindPresenter(SecondPresenter.class, SecondPresenter.MyView.class,
				SecondView.class, SecondPresenter.MyProxy.class);

		bindPresenter(HeaderPresenter.class, HeaderPresenter.MyView.class,
				HeaderView.class, HeaderPresenter.MyProxy.class);

		bindPresenter(ThirdPresenter.class, ThirdPresenter.MyView.class,
				ThirdView.class, ThirdPresenter.MyProxy.class);

		bindPresenterWidget(RatePagePresenter.class,
				RatePagePresenter.MyView.class, RatePageView.class);

		bindPresenterWidget(WhyNotPresenter.class,
				WhyNotPresenter.MyView.class, WhyNotView.class);

		bindPresenter(ErrorPresenter.class, ErrorPresenter.MyView.class,
				ErrorView.class, ErrorPresenter.MyProxy.class);

		bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class,
				LoginView.class, LoginPresenter.MyProxy.class);
	}
}
