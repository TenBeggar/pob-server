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
        StopWatch stopWatch = new StopWatch();
        log.info("POB启动中...");
        stopWatch.start("《英雄联盟》获取最新版本");
        List<String> versions = dragonClient.allVersions();
        if (CollectionUtils.isEmpty(versions)) {
            throw new RuntimeException("获取LOL所有版本失败");
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
            dragonService.syncChampion(latestVersion, language);
            historyVersionRepository.save(HistoryVersionEntity.builder().version(latestVersion).language(language).build());
        }
        stopWatch.stop();
        stopWatch.start("《POB》缓存英雄数据");
        dragonService.setCurrentVersion(latestVersion);
        dragonService.setChampionMap(latestVersion);
        stopWatch.stop();
        log.info("POB启动完成");
        log.info(stopWatch.prettyPrint());
    }
}
