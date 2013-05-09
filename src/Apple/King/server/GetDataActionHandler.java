package Apple.King.server;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import Apple.King.client.GetData;
import Apple.King.client.GetDataResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetDataActionHandler implements
		ActionHandler<GetData, GetDataResult> {

	@Inject
	public GetDataActionHandler() {
	}

	@Override
	public GetDataResult execute(GetData action, ExecutionContext context)
			throws ActionException {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		return new GetDataResult("Here is some Data");
	}

	@Override
	public void undo(GetData action, GetDataResult result, ExecutionContext context)
			throws ActionException {
	}

	@Override
	public Class<GetData> getActionType() {
		return GetData.class;
	}
}
