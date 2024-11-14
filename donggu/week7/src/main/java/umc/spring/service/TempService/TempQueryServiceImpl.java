package umc.spring.service.TempService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.spring.api.code.status.ErrorStatus;
import umc.spring.api.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

	@Override
	public void CheckFlag(Integer flag) {
		if (flag == 1)
			throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
	}
}
