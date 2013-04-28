package Apple.King.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import Apple.King.client.place.ClientPlaceManager;
import Apple.King.client.FirstPresenter;
import Apple.King.client.FirstView;
import Apple.King.client.place.DefaultPlace;
import Apple.King.client.place.NameTokens;
import Apple.King.client.SecondPresenter;
import Apple.King.client.SecondView;
import Apple.King.client.HeaderPresenter;
import Apple.King.client.HeaderView;
import Apple.King.client.ThirdPresenter;
import Apple.King.client.ThirdView;
import Apple.King.client.RatePagePresenter;
import Apple.King.client.RatePageView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(FirstPresenter.class, FirstPresenter.MyView.class,
				FirstView.class, FirstPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.first);

		bindPresenter(SecondPresenter.class, SecondPresenter.MyView.class,
				SecondView.class, SecondPresenter.MyProxy.class);

		bindPresenter(HeaderPresenter.class, HeaderPresenter.MyView.class,
				HeaderView.class, HeaderPresenter.MyProxy.class);

		bindPresenter(ThirdPresenter.class, ThirdPresenter.MyView.class,
				ThirdView.class, ThirdPresenter.MyProxy.class);

		bindPresenterWidget(RatePagePresenter.class,
				RatePagePresenter.MyView.class, RatePageView.class);
	}
}
