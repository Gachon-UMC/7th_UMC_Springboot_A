package umc.spring.temp.service.TempService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

	@Override
	public void CheckFlag(Integer flag) {
		if (flag == 1)
			throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
	}
}
