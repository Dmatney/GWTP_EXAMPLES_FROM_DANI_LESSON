package Apple.King.client;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HasHandlers;

public class UserNotHappyEvent extends
		GwtEvent<UserNotHappyEvent.UserNotHappyHandler> {

	public static Type<UserNotHappyHandler> TYPE = new Type<UserNotHappyHandler>();

	public interface UserNotHappyHandler extends EventHandler {
		void onUserNotHappy(UserNotHappyEvent event);
	}

	public UserNotHappyEvent() {
	}

	@Override
	protected void dispatch(UserNotHappyHandler handler) {
		handler.onUserNotHappy(this);
	}

	@Override
	public Type<UserNotHappyHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<UserNotHappyHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new UserNotHappyEvent());
	}
}
