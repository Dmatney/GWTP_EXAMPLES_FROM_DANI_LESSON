package Apple.King.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class RatePagePresenter extends
		PresenterWidget<RatePagePresenter.MyView> {

	public interface MyView extends View {
		public Button getYesButton();
		public Button getNoButton();
	}

	@Inject
	public RatePagePresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getYesButton().addClickHandler(new ClickHandler(){
			
			@Override
			public void onClick(ClickEvent event){
				Window.alert("That is great!");
			}
		});
		getView().getNoButton().addClickHandler(new ClickHandler(){
			
			@Override
			public void onClick(ClickEvent event){
				Window.alert("I am sorry to hear that");
			}
		});
	}
}
