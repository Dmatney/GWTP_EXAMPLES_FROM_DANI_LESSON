package Apple.King.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class WhyNotPresenter extends PresenterWidget<WhyNotPresenter.MyView> {

	public interface MyView extends PopupView {
		public Button getOkButton() ;
	}

	@Inject
	public WhyNotPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
			getView().getOkButton().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						getView().hide();
					}
			});
	}
}
