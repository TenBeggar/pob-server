package com.tenbeggar.pob.manager;

import com.tenbeggar.pob.entity.HistoryVersionEntity;
import com.tenbeggar.pob.repository.HistoryVersionRepository;
import com.tenbeggar.pob.riot.DragonClient;
import com.tenbeggar.pob.riot.RiotProperties;
import com.tenbeggar.pob.service.DragonService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class DragonRunner implements ApplicationRunner {

    @Resource
    private RiotProperties riotProperties;
    @Resource
    private DragonClient dragonClient;
    @Resource
    private DragonService dragonService;

    @Resource
    private HistoryVersionRepository historyVersionRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        log.info("POB启动中...");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("《英雄联盟》获取最新版本");
        List<String> versions = dragonClient.allVersion();
        if (CollectionUtils.isEmpty(versions)) {
            throw new RuntimeException("Request LOL version failed");
        }
        String latestVersion = versions.get(0);
        stopWatch.stop();
        stopWatch.start("《英雄联盟》资源下载");
        dragonService.downloadDataDragon(latestVersion);
        stopWatch.stop();
        stopWatch.start("《英雄联盟》同步英雄数据");
        String language = riotProperties.getLanguage();
        HistoryVersionEntity historyVersionEntity = historyVersionRepository.findAllByVersionAndLanguage(latestVersion, language);
        if (Objects.isNull(historyVersionEntity)) {
            dragonService.syncData(latestVersion);
            historyVersionRepository.save(HistoryVersionEntity.builder().version(latestVersion).language(language).build());
        }
        stopWatch.stop();
        stopWatch.start("《POB》缓存版本数据");
        dragonService.setData(latestVersion);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        log.info("POB启动完成");
    }
}
