CREATE TABLE ban
(
    pob_id        varchar(18) NOT NULL,
    champion_id   int4 NULL,
    game_creation int8 NULL,
    game_version  varchar(32) NULL,
    match_id      varchar(32) NULL,
    pick_turn     int4 NULL,
    queue_id      int4 NULL,
    team_id       int4 NULL,
    CONSTRAINT ban_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE champion
(
    pob_id      varchar(18) NOT NULL,
    allytips    varchar(1000) NULL,
    blurb       varchar(1000) NULL,
    en_id       varchar(32) NULL,
    enemytips   varchar(1000) NULL,
    id          int4 NULL,
    image       varchar(64) NULL,
    "language"  varchar(8) NULL,
    lore        varchar(1000) NULL,
    "name"      varchar(32) NULL,
    partype     varchar(32) NULL,
    recommended varchar(1000) NULL,
    score       varchar(1000) NULL,
    tags        varchar(128) NULL,
    title       varchar(32) NULL,
    "version"   varchar(32) NULL,
    CONSTRAINT champion_pkey PRIMARY KEY (pob_id),
    CONSTRAINT champion_id_version_language_unique UNIQUE (id, version, language)
);

CREATE TABLE champion_passive
(
    pob_id      varchar(18) NOT NULL,
    champion_id int4 NULL,
    description varchar(1000) NULL,
    image       varchar(64) NULL,
    "language"  varchar(8) NULL,
    "name"      varchar(32) NULL,
    "version"   varchar(32) NULL,
    CONSTRAINT champion_passive_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE champion_skin
(
    pob_id      varchar(18) NOT NULL,
    champion_id int4 NULL,
    chromas     bool NULL,
    id          varchar(32) NULL,
    "language"  varchar(8) NULL,
    "name"      varchar(128) NULL,
    num         int4 NULL,
    "version"   varchar(32) NULL,
    CONSTRAINT champion_skin_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE champion_spell
(
    pob_id        varchar(18) NOT NULL,
    champion_id   int4 NULL,
    cooldown_burn varchar(32) NULL,
    cost_burn     varchar(32) NULL,
    description   varchar(1000) NULL,
    id            varchar(32) NULL,
    image         varchar(64) NULL,
    "language"    varchar(8) NULL,
    maxammo       varchar(8) NULL,
    maxrank       int4 NULL,
    "name"        varchar(32) NULL,
    range_burn    varchar(32) NULL,
    "version"     varchar(32) NULL,
    CONSTRAINT champion_spell_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE champion_stats
(
    pob_id               varchar(18) NOT NULL,
    armor                int4 NULL,
    armorperlevel        float4 NULL,
    attackdamage         int4 NULL,
    attackdamageperlevel float4 NULL,
    attackrange          int4 NULL,
    attackspeed          float4 NULL,
    attackspeedperlevel  float4 NULL,
    champion_id          int4 NULL,
    crit                 int4 NULL,
    critperlevel         float4 NULL,
    hp                   int4 NULL,
    hpperlevel           float4 NULL,
    hpregen              float4 NULL,
    hpregenperlevel      float4 NULL,
    "language"           varchar(8) NULL,
    movespeed            int4 NULL,
    mp                   int4 NULL,
    mpperlevel           float4 NULL,
    mpregen              float4 NULL,
    mpregenperlevel      float4 NULL,
    spellblock           int4 NULL,
    spellblockperlevel   float4 NULL,
    "version"            varchar(32) NULL,
    CONSTRAINT champion_stats_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE history_version
(
    pob_id   varchar(18) NOT NULL,
    version  varchar(32) NULL,
    language varchar(8) NULL,
    CONSTRAINT history_version_pkey PRIMARY KEY (pob_id),
    CONSTRAINT history_version_version_language_unique UNIQUE (version, language)
);

CREATE TABLE "match"
(
    pob_id               varchar(18) NOT NULL,
    data_version         varchar(8) NULL,
    game_creation        int8 NULL,
    game_duration        int8 NULL,
    game_end_timestamp   int8 NULL,
    game_id              int8 NULL,
    game_mode            varchar(32) NULL,
    game_name            varchar(64) NULL,
    game_start_timestamp int8 NULL,
    game_type            varchar(32) NULL,
    game_version         varchar(32) NULL,
    map_id               int4 NULL,
    match_id             varchar(32) NULL,
    platform_id          varchar(8) NULL,
    queue_id             int4 NULL,
    tournament_code      varchar(128) NULL,
    CONSTRAINT match_pkey PRIMARY KEY (pob_id),
    CONSTRAINT match_match_id_unique UNIQUE (match_id)
);

CREATE TABLE match_task
(
    pob_id      varchar(18) NOT NULL,
    continent   varchar(32) NULL,
    count       int4 NULL,
    end_time    int8 NULL,
    puuid       varchar(128) NULL,
    retry_count int4 NULL,
    "start"     int4 NULL,
    start_time  int8 NULL,
    status      varchar(32) NULL,
    CONSTRAINT match_task_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE match_task_billboard
(
    pob_id     varchar(18) NOT NULL,
    continent  varchar(32) NULL,
    end_time   int8 NULL,
    puuid      varchar(128) NULL,
    start_time int8 NULL,
    CONSTRAINT match_task_billboard_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE objective
(
    pob_id         varchar(18) NOT NULL,
    "first"        bool NULL,
    game_creation  int8 NULL,
    game_version   varchar(32) NULL,
    kills          int4 NULL,
    match_id       varchar(32) NULL,
    objective_name varchar(32) NULL,
    queue_id       int4 NULL,
    team_id        int4 NULL,
    CONSTRAINT objective_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE participant
(
    pob_id                             varchar(18) NOT NULL,
    all_in_pings                       int4 NULL,
    assist_me_pings                    int4 NULL,
    assists                            int4 NULL,
    bait_pings                         int4 NULL,
    baron_kills                        int4 NULL,
    basic_pings                        int4 NULL,
    bounty_level                       int4 NULL,
    champ_experience                   int4 NULL,
    champ_level                        int4 NULL,
    champion_id                        int4 NULL,
    champion_name                      varchar(128) NULL,
    champion_transform                 int4 NULL,
    command_pings                      int4 NULL,
    consumables_purchased              int4 NULL,
    damage_dealt_to_buildings          int4 NULL,
    damage_dealt_to_objectives         int4 NULL,
    damage_dealt_to_turrets            int4 NULL,
    damage_self_mitigated              int4 NULL,
    danger_pings                       int4 NULL,
    deaths                             int4 NULL,
    detector_wards_placed              int4 NULL,
    double_kills                       int4 NULL,
    dragon_kills                       int4 NULL,
    eligible_for_progression           bool NULL,
    enemy_missing_pings                int4 NULL,
    enemy_vision_pings                 int4 NULL,
    first_blood_assist                 bool NULL,
    first_blood_kill                   bool NULL,
    first_tower_assist                 bool NULL,
    first_tower_kill                   bool NULL,
    game_creation                      int8 NULL,
    game_ended_in_early_surrender      bool NULL,
    game_ended_in_surrender            bool NULL,
    game_version                       varchar(32) NULL,
    get_back_pings                     int4 NULL,
    gold_earned                        int4 NULL,
    gold_spent                         int4 NULL,
    hold_pings                         int4 NULL,
    individual_position                varchar(32) NULL,
    inhibitor_kills                    int4 NULL,
    inhibitor_takedowns                int4 NULL,
    inhibitors_lost                    int4 NULL,
    item0                              int4 NULL,
    item1                              int4 NULL,
    item2                              int4 NULL,
    item3                              int4 NULL,
    item4                              int4 NULL,
    item5                              int4 NULL,
    item6                              int4 NULL,
    items_purchased                    int4 NULL,
    killing_sprees                     int4 NULL,
    kills                              int4 NULL,
    lane                               varchar(32) NULL,
    largest_critical_strike            int4 NULL,
    largest_killing_spree              int4 NULL,
    largest_multi_kill                 int4 NULL,
    longest_time_spent_living          int4 NULL,
    magic_damage_dealt                 int4 NULL,
    magic_damage_dealt_to_champions    int4 NULL,
    magic_damage_taken                 int4 NULL,
    match_id                           varchar(32) NULL,
    need_vision_pings                  int4 NULL,
    neutral_minions_killed             int4 NULL,
    nexus_kills                        int4 NULL,
    nexus_lost                         int4 NULL,
    nexus_takedowns                    int4 NULL,
    objectives_stolen                  int4 NULL,
    objectives_stolen_assists          int4 NULL,
    on_my_way_pings                    int4 NULL,
    participant_id                     int4 NULL,
    penta_kills                        int4 NULL,
    physical_damage_dealt              int4 NULL,
    physical_damage_dealt_to_champions int4 NULL,
    physical_damage_taken              int4 NULL,
    placement                          int4 NULL,
    player_augment1                    int4 NULL,
    player_augment2                    int4 NULL,
    player_augment3                    int4 NULL,
    player_augment4                    int4 NULL,
    player_subteam_id                  int4 NULL,
    profile_icon                       int4 NULL,
    push_pings                         int4 NULL,
    puuid                              varchar(128) NULL,
    quadra_kills                       int4 NULL,
    queue_id                           int4 NULL,
    riot_id_game_name                  varchar(128) NULL,
    riot_id_name                       varchar(128) NULL,
    riot_id_tagline                    varchar(32) NULL,
    "role"                             varchar(32) NULL,
    sight_wards_bought_in_game         int4 NULL,
    spell1casts                        int4 NULL,
    spell2casts                        int4 NULL,
    spell3casts                        int4 NULL,
    spell4casts                        int4 NULL,
    subteam_placement                  int4 NULL,
    summoner1casts                     int4 NULL,
    summoner1id                        int4 NULL,
    summoner2casts                     int4 NULL,
    summoner2id                        int4 NULL,
    summoner_id                        varchar(64) NULL,
    summoner_level                     int4 NULL,
    summoner_name                      varchar(128) NULL,
    team_early_surrendered             bool NULL,
    team_id                            int4 NULL,
    team_position                      varchar(32) NULL,
    timeccing_others                   int4 NULL,
    time_played                        int4 NULL,
    total_ally_jungle_minions_killed   int4 NULL,
    total_damage_dealt                 int4 NULL,
    total_damage_dealt_to_champions    int4 NULL,
    total_damage_shielded_on_teammates int4 NULL,
    total_damage_taken                 int4 NULL,
    total_enemy_jungle_minions_killed  int4 NULL,
    total_heal                         int4 NULL,
    total_heals_on_teammates           int4 NULL,
    total_minions_killed               int4 NULL,
    total_timeccdealt                  int4 NULL,
    total_time_spent_dead              int4 NULL,
    total_units_healed                 int4 NULL,
    triple_kills                       int4 NULL,
    true_damage_dealt                  int4 NULL,
    true_damage_dealt_to_champions     int4 NULL,
    true_damage_taken                  int4 NULL,
    turret_kills                       int4 NULL,
    turret_takedowns                   int4 NULL,
    turrets_lost                       int4 NULL,
    unreal_kills                       int4 NULL,
    vision_cleared_pings               int4 NULL,
    vision_score                       int4 NULL,
    vision_wards_bought_in_game        int4 NULL,
    wards_killed                       int4 NULL,
    wards_placed                       int4 NULL,
    win                                bool NULL,
    CONSTRAINT participant_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE summoner
(
    pob_id          varchar(18) NOT NULL,
    account_id      varchar(64) NULL,
    id              varchar(64) NULL,
    "name"          varchar(128) NULL,
    profile_icon_id int4 NULL,
    puuid           varchar(128) NULL,
    region          varchar(8) NULL,
    revision_date   int8 NULL,
    summoner_level  int8 NULL,
    CONSTRAINT summoner_pkey PRIMARY KEY (pob_id),
    CONSTRAINT summoner_puuid_unique UNIQUE (puuid)
);

CREATE TABLE summoner_match
(
    pob_id   varchar(18) NOT NULL,
    match_id varchar(32) NULL,
    puuid    varchar(128) NULL,
    CONSTRAINT summoner_match_pkey PRIMARY KEY (pob_id),
    CONSTRAINT summoner_match_puuid_match_id_unique UNIQUE (puuid, match_id)
);

CREATE TABLE summoner_spell
(
    pob_id         varchar(18) NOT NULL,
    cooldown_burn  varchar(32) NULL,
    cost_burn      varchar(32) NULL,
    cost_type      varchar(32) NULL,
    description    varchar(1000) NULL,
    en_id          varchar(32) NULL,
    id             int4 NULL,
    image          varchar(64) NULL,
    "language"     varchar(8) NULL,
    modes          varchar(1000) NULL,
    maxammo        varchar(8) NULL,
    maxrank        int4 NULL,
    "name"         varchar(32) NULL,
    range_burn     varchar(32) NULL,
    summoner_level int4 NULL,
    "version"      varchar(32) NULL,
    CONSTRAINT summoner_spell_pkey PRIMARY KEY (pob_id)
);

CREATE TABLE team
(
    pob_id        varchar(18) NOT NULL,
    game_creation int8 NULL,
    game_version  varchar(32) NULL,
    match_id      varchar(32) NULL,
    queue_id      int4 NULL,
    team_id       int4 NULL,
    win           bool NULL,
    CONSTRAINT team_pkey PRIMARY KEY (pob_id)
);