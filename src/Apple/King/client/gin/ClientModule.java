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

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(FirstPresenter.class, FirstPresenter.MyView.class,
				FirstView.class, FirstPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.first);

		bindPresenter(SecondPresenter.class, SecondPresenter.MyView.class,
				SecondView.class, SecondPresenter.MyProxy.class);
	}
}
