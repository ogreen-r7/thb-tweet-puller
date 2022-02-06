package analyzer;

import model.tweet.Tweet;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class TweetParserTest {

    @Test
    void parseTweetWrapper() {
        String tweet1 = "{\"created_at\":\"Sun Feb 06 12:55:16 +0000 2022\",\"id\":1490308110606548992,\"id_str\":\"1490308110606548992\",\"text\":\"@MrOverUnder @nbastats @nba @nbastats please review russ Giannis should be awarded a rebound. This would give him a double double!\",\"display_text_range\":[23,130],\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/iphone\\\" rel=\\\"nofollow\\\"\\u003eTwitter for iPhone\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":1490200374497746954,\"in_reply_to_status_id_str\":\"1490200374497746954\",\"in_reply_to_user_id\":1206605893464469505,\"in_reply_to_user_id_str\":\"1206605893464469505\",\"in_reply_to_screen_name\":\"MrOverUnder\",\"user\":{\"id\":174124052,\"id_str\":\"174124052\",\"name\":\"Rem\",\"screen_name\":\"WillRem\",\"location\":\"Michigan, USA\",\"url\":null,\"description\":\"University at Buffalo Alum ...\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":847,\"friends_count\":790,\"listed_count\":1,\"favourites_count\":5447,\"statuses_count\":42713,\"created_at\":\"Tue Aug 03 04:32:11 +0000 2010\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"1A1B1F\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme9\\/bg.gif\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme9\\/bg.gif\",\"profile_background_tile\":true,\"profile_link_color\":\"700101\",\"profile_sidebar_border_color\":\"181A1E\",\"profile_sidebar_fill_color\":\"252429\",\"profile_text_color\":\"666666\",\"profile_use_background_image\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1304090225547907072\\/2oQtb3Nj_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1304090225547907072\\/2oQtb3Nj_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/174124052\\/1580086843\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"withheld_in_countries\":[]},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[{\"screen_name\":\"MrOverUnder\",\"name\":\"MrOverUnder\",\"id\":1206605893464469505,\"id_str\":\"1206605893464469505\",\"indices\":[0,12]},{\"screen_name\":\"nbastats\",\"name\":\"NBA.com\\/Stats\",\"id\":283090686,\"id_str\":\"283090686\",\"indices\":[13,22]},{\"screen_name\":\"NBA\",\"name\":\"NBA\",\"id\":19923144,\"id_str\":\"19923144\",\"indices\":[23,27]},{\"screen_name\":\"nbastats\",\"name\":\"NBA.com\\/Stats\",\"id\":283090686,\"id_str\":\"283090686\",\"indices\":[28,37]}],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"en\",\"timestamp_ms\":\"1644152116811\"}";
        String tweet2 = "{\"created_at\":\"Sun Feb 06 12:55:15 +0000 2022\",\"id\":1490308103681699841,\"id_str\":\"1490308103681699841\",\"text\":\"RT @iRis_k_miyu: \\u3042\\u308a\\u304c\\u3068\\u3046\\u3054\\u3056\\u3044\\u307e\\u3057\\u305f\\uff01\\n\\u81ea\\u5206\\u9054\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u7d42\\u308f\\u3063\\u305f\\u5f8c\\u3001\\u8a66\\u5408\\u3092\\u89b3\\u3055\\u305b\\u3066\\u3044\\u305f\\u3060\\u3044\\u305f\\u306e\\u3067\\u3059\\u304c\\u2026\\u3059\\u3054\\u304b\\u3063\\u305f\\u30fc\\uff01\\uff01\\uff01\\u751f\\u306e\\u8a66\\u5408\\u3063\\u3066\\u3059\\u3054\\u3044\\u3067\\u3059\\u306d\\uff01\\uff01\\u5c55\\u958b\\u306b\\u71b1\\u304f\\u306a\\u308a\\u307e\\u3059\\u306d\\uff01\\uff01\\ud83d\\udd25\\ud83d\\udd25\\ud83d\\udd25\\u3000\\u697d\\u3057\\u307e\\u305b\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u3057\\u305f\\uff01\\uff01\\u263a\\ufe0f https:\\/\\/t.co\\/At94iq\\u2026\",\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/iphone\\\" rel=\\\"nofollow\\\"\\u003eTwitter for iPhone\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":3690209486,\"id_str\":\"3690209486\",\"name\":\"ROX Smeb\",\"screen_name\":\"minacding\",\"location\":\"Hsinchu County, Taiwan\",\"url\":null,\"description\":null,\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":83,\"friends_count\":1194,\"listed_count\":3,\"favourites_count\":38460,\"statuses_count\":40677,\"created_at\":\"Sat Sep 26 07:27:39 +0000 2015\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"1DA1F2\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/928957731691573249\\/NhaIZFWX_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/928957731691573249\\/NhaIZFWX_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/3690209486\\/1510315811\",\"default_profile\":true,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"withheld_in_countries\":[]},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweeted_status\":{\"created_at\":\"Sun Feb 06 10:15:20 +0000 2022\",\"id\":1490267860283052038,\"id_str\":\"1490267860283052038\",\"text\":\"\\u3042\\u308a\\u304c\\u3068\\u3046\\u3054\\u3056\\u3044\\u307e\\u3057\\u305f\\uff01\\n\\u81ea\\u5206\\u9054\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u7d42\\u308f\\u3063\\u305f\\u5f8c\\u3001\\u8a66\\u5408\\u3092\\u89b3\\u3055\\u305b\\u3066\\u3044\\u305f\\u3060\\u3044\\u305f\\u306e\\u3067\\u3059\\u304c\\u2026\\u3059\\u3054\\u304b\\u3063\\u305f\\u30fc\\uff01\\uff01\\uff01\\u751f\\u306e\\u8a66\\u5408\\u3063\\u3066\\u3059\\u3054\\u3044\\u3067\\u3059\\u306d\\uff01\\uff01\\u5c55\\u958b\\u306b\\u71b1\\u304f\\u306a\\u308a\\u307e\\u3059\\u306d\\uff01\\uff01\\ud83d\\udd25\\ud83d\\udd25\\ud83d\\udd25\\u3000\\u697d\\u3057\\u307e\\u305b\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u3057\\u305f\\uff01\\uff01\\u263a\\ufe0f\\u2026 https:\\/\\/t.co\\/7PzZwap4SK\",\"display_text_range\":[0,140],\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/iphone\\\" rel=\\\"nofollow\\\"\\u003eTwitter for iPhone\\u003c\\/a\\u003e\",\"truncated\":true,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":2384783184,\"id_str\":\"2384783184\",\"name\":\"\\u4e45\\u4fdd\\u7530\\u672a\\u5922(i\\u2606Ris)\",\"screen_name\":\"iRis_k_miyu\",\"location\":null,\"url\":\"http:\\/\\/iris.dive2ent.com\",\"description\":\"\\u58f0\\u512a\\uff0f\\u30a2\\u30a4\\u30c9\\u30eb\\uff0f \\u516c\\u5f0fLINE\\u30a2\\u30ab\\u30a6\\u30f3\\u30c8\\u3067\\u304d\\u307e\\u3057\\u305f\\uff01https:\\/\\/lin.ee\\/2WlF90o \\uff0f 1\\u670831\\u65e52nd\\u5199\\u771f\\u96c6\\u300cUP_DATE\\u300d\\u767a\\u58f2\\ud83c\\udfdd\\ud83c\\udf3a #\\u3093\\u307f\\u3083\\u30fc\\u30612nd\\u5199\\u771f\\u96c6\\u3055\\u30fc \\uff0f#\\u3053\\u3093\\u306b\\u304f\\u307c\\u305f #\\u30af\\u30dc\\u30bf\\u30e8\\u30fc\\u30b0\\u30eb\\u30c8 \\u304a\\u8089\\u3068\\u30e8\\u30fc\\u30b0\\u30eb\\u30c8\\u3068\\u30b7\\u30e3\\u30a4\\u30f3\\u30de\\u30b9\\u30ab\\u30c3\\u30c8\\u304c\\u3059\\u304d\\u3067\\u3059\\u3002\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":189186,\"friends_count\":705,\"listed_count\":6274,\"favourites_count\":2405,\"statuses_count\":28251,\"created_at\":\"Wed Mar 12 06:26:18 +0000 2014\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"1DA1F2\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1446432270194143241\\/Bt58AQ6X_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1446432270194143241\\/Bt58AQ6X_normal.jpg\",\"default_profile\":true,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"withheld_in_countries\":[]},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"quoted_status_id\":1490235578356363264,\"quoted_status_id_str\":\"1490235578356363264\",\"quoted_status\":{\"created_at\":\"Sun Feb 06 08:07:03 +0000 2022\",\"id\":1490235578356363264,\"id_str\":\"1490235578356363264\",\"text\":\"\\ud83c\\udfc0#\\u8a66\\u5408\\u901f\\u5831 powered by #\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\\ud83c\\udfc0\\n\\n2\\/6(\\u65e5) \\n\\u30cf\\u30fc\\u30d5\\u30bf\\u30a4\\u30e0\\n43 #\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\n31 #\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\\n\\n\\u300ci\\u2606Ris(\\u30a2\\u30a4\\u30ea\\u30b9)\\u300d\\u306e\\u7686\\u3055\\u3093\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u3067\\u76db\\u308a\\u4e0a\\u3052\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u2026 https:\\/\\/t.co\\/7f7qzGRURd\",\"display_text_range\":[0,140],\"source\":\"\\u003ca href=\\\"http:\\/\\/wsc-sports.com\\\" rel=\\\"nofollow\\\"\\u003eWSC Sports\\u003c\\/a\\u003e\",\"truncated\":true,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":717542939631595520,\"id_str\":\"717542939631595520\",\"name\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\u26a1\\ufe0f\\u6b21\\u56de\\u30db\\u30fc\\u30e0\\u6226 2\\/12,13 vs\\u7fa4\\u99ac @\\u3068\\u3069\\u308d\\u304d\\u30a2\\u30ea\\u30fc\\u30ca\",\"screen_name\":\"brave_thunders\",\"location\":\"\\u795e\\u5948\\u5ddd\\u770c\\u5ddd\\u5d0e\\u5e02\",\"url\":\"http:\\/\\/kawasaki-bravethunders.com\\/\",\"description\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\u516c\\u5f0f\\u3067\\u3059\\u3002\\u300cMAKE THE FUTURE OF BASKETBALL \\u301c\\u5ddd\\u5d0e\\u304b\\u3089\\u30d0\\u30b9\\u30b1\\u306e\\u672a\\u6765\\u3092\\u301c\\u300d \\u5ddd\\u5d0e\\u5e02\\u3092\\u30db\\u30fc\\u30e0\\u30bf\\u30a6\\u30f3\\u3068\\u3057\\u305fB.LEAGUE B1(1\\u90e8)\\u306b\\u6240\\u5c5e\\u3059\\u308b\\u30d7\\u30ed\\u30d0\\u30b9\\u30b1\\u30c3\\u30c8\\u30dc\\u30fc\\u30eb\\u30af\\u30e9\\u30d6\\u3067\\u3059\\u3002\\u30af\\u30e9\\u30d6\\u3078\\u306e\\u304a\\u554f\\u3044\\u5408\\u308f\\u305b\\u306f\\u3001\\u516c\\u5f0fWEB\\u30b5\\u30a4\\u30c8\\u306e\\u5c02\\u7528\\u30d5\\u30a9\\u30fc\\u30e0\\u3092\\u3054\\u5229\\u7528\\u304f\\u3060\\u3055\\u3044\\u3002\",\"translator_type\":\"none\",\"protected\":false,\"verified\":true,\"followers_count\":75891,\"friends_count\":203,\"listed_count\":638,\"favourites_count\":10683,\"statuses_count\":26237,\"created_at\":\"Wed Apr 06 02:42:22 +0000 2016\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"8F0038\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1278126934308737024\\/4zMn_nYk_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1278126934308737024\\/4zMn_nYk_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/717542939631595520\\/1632554071\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"withheld_in_countries\":[]},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"extended_tweet\":{\"full_text\":\"\\ud83c\\udfc0#\\u8a66\\u5408\\u901f\\u5831 powered by #\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\\ud83c\\udfc0\\n\\n2\\/6(\\u65e5) \\n\\u30cf\\u30fc\\u30d5\\u30bf\\u30a4\\u30e0\\n43 #\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\n31 #\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\\n\\n\\u300ci\\u2606Ris(\\u30a2\\u30a4\\u30ea\\u30b9)\\u300d\\u306e\\u7686\\u3055\\u3093\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u3067\\u76db\\u308a\\u4e0a\\u3052\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u3057\\u305f\\u2728\\n@iris_official_ #i_Ris\\n\\n#\\u30d0\\u30b9\\u30b1\\u30c3\\u30c8LIVE \\u3067\\u914d\\u4fe1\\u4e2d\\ud83d\\udcf1\\nhttps:\\/\\/t.co\\/C6HZDwP6P9 https:\\/\\/t.co\\/DlkSjBTfW7\",\"display_text_range\":[0,183],\"entities\":{\"hashtags\":[{\"text\":\"\\u8a66\\u5408\\u901f\\u5831\",\"indices\":[1,6]},{\"text\":\"\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\",\"indices\":[18,30]},{\"text\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\",\"indices\":[51,63]},{\"text\":\"\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\",\"indices\":[67,77]},{\"text\":\"i_Ris\",\"indices\":[135,141]},{\"text\":\"\\u30d0\\u30b9\\u30b1\\u30c3\\u30c8LIVE\",\"indices\":[143,153]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/C6HZDwP6P9\",\"expanded_url\":\"https:\\/\\/basketball.mb.softbank.jp\\/lives\\/7799?utm_source=club&utm_medium=kawasaki-bravethunders&utm_campaign=077\",\"display_url\":\"basketball.mb.softbank.jp\\/lives\\/7799?utm\\u2026\",\"indices\":[160,183]}],\"user_mentions\":[{\"screen_name\":\"iris_official_\",\"name\":\"i\\u2606Ris\",\"id\":779723154,\"id_str\":\"779723154\",\"indices\":[119,134]}],\"symbols\":[],\"media\":[{\"id\":1490235470416015361,\"id_str\":\"1490235470416015361\",\"indices\":[184,207],\"additional_media_info\":{\"monetizable\":false},\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"url\":\"https:\\/\\/t.co\\/DlkSjBTfW7\",\"display_url\":\"pic.twitter.com\\/DlkSjBTfW7\",\"expanded_url\":\"https:\\/\\/twitter.com\\/brave_thunders\\/status\\/1490235578356363264\\/video\\/1\",\"type\":\"video\",\"video_info\":{\"aspect_ratio\":[16,9],\"duration_millis\":41700,\"variants\":[{\"content_type\":\"application\\/x-mpegURL\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/pl\\/m7jBiC_ht7UgmQNs.m3u8?tag=14&container=fmp4\"},{\"bitrate\":288000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/480x270\\/iiYxJeCU39rN0Zwm.mp4?tag=14\"},{\"bitrate\":832000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/640x360\\/DylfH3yoZJT_dyY_.mp4?tag=14\"},{\"bitrate\":2176000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/1280x720\\/3VtjS0uKoHaDt0pg.mp4?tag=14\"}]},\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1920,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":675,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":383,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":1490235470416015361,\"id_str\":\"1490235470416015361\",\"indices\":[184,207],\"additional_media_info\":{\"monetizable\":false},\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"url\":\"https:\\/\\/t.co\\/DlkSjBTfW7\",\"display_url\":\"pic.twitter.com\\/DlkSjBTfW7\",\"expanded_url\":\"https:\\/\\/twitter.com\\/brave_thunders\\/status\\/1490235578356363264\\/video\\/1\",\"type\":\"video\",\"video_info\":{\"aspect_ratio\":[16,9],\"duration_millis\":41700,\"variants\":[{\"content_type\":\"application\\/x-mpegURL\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/pl\\/m7jBiC_ht7UgmQNs.m3u8?tag=14&container=fmp4\"},{\"bitrate\":288000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/480x270\\/iiYxJeCU39rN0Zwm.mp4?tag=14\"},{\"bitrate\":832000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/640x360\\/DylfH3yoZJT_dyY_.mp4?tag=14\"},{\"bitrate\":2176000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/1280x720\\/3VtjS0uKoHaDt0pg.mp4?tag=14\"}]},\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1920,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":675,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":383,\"resize\":\"fit\"}}}]}},\"quote_count\":78,\"reply_count\":1,\"retweet_count\":795,\"favorite_count\":1828,\"entities\":{\"hashtags\":[{\"text\":\"\\u8a66\\u5408\\u901f\\u5831\",\"indices\":[1,6]},{\"text\":\"\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\",\"indices\":[18,30]},{\"text\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\",\"indices\":[51,63]},{\"text\":\"\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\",\"indices\":[67,77]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/7f7qzGRURd\",\"expanded_url\":\"https:\\/\\/twitter.com\\/i\\/web\\/status\\/1490235578356363264\",\"display_url\":\"twitter.com\\/i\\/web\\/status\\/1\\u2026\",\"indices\":[117,140]}],\"user_mentions\":[],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"ja\"},\"quoted_status_permalink\":{\"url\":\"https:\\/\\/t.co\\/hU0h2HA0ig\",\"expanded\":\"https:\\/\\/twitter.com\\/brave_thunders\\/status\\/1490235578356363264\",\"display\":\"twitter.com\\/brave_thunders\\u2026\"},\"is_quote_status\":true,\"extended_tweet\":{\"full_text\":\"\\u3042\\u308a\\u304c\\u3068\\u3046\\u3054\\u3056\\u3044\\u307e\\u3057\\u305f\\uff01\\n\\u81ea\\u5206\\u9054\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u7d42\\u308f\\u3063\\u305f\\u5f8c\\u3001\\u8a66\\u5408\\u3092\\u89b3\\u3055\\u305b\\u3066\\u3044\\u305f\\u3060\\u3044\\u305f\\u306e\\u3067\\u3059\\u304c\\u2026\\u3059\\u3054\\u304b\\u3063\\u305f\\u30fc\\uff01\\uff01\\uff01\\u751f\\u306e\\u8a66\\u5408\\u3063\\u3066\\u3059\\u3054\\u3044\\u3067\\u3059\\u306d\\uff01\\uff01\\u5c55\\u958b\\u306b\\u71b1\\u304f\\u306a\\u308a\\u307e\\u3059\\u306d\\uff01\\uff01\\ud83d\\udd25\\ud83d\\udd25\\ud83d\\udd25\\u3000\\u697d\\u3057\\u307e\\u305b\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u3057\\u305f\\uff01\\uff01\\u263a\\ufe0f https:\\/\\/t.co\\/At94iqMncT\",\"display_text_range\":[0,102],\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[],\"symbols\":[],\"media\":[{\"id\":1490267852406157316,\"id_str\":\"1490267852406157316\",\"indices\":[103,126],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/FK5-t0racAQ6Vir.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/FK5-t0racAQ6Vir.jpg\",\"url\":\"https:\\/\\/t.co\\/At94iqMncT\",\"display_url\":\"pic.twitter.com\\/At94iqMncT\",\"expanded_url\":\"https:\\/\\/twitter.com\\/iRis_k_miyu\\/status\\/1490267860283052038\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":1200,\"h\":900,\"resize\":\"fit\"},\"large\":{\"w\":1504,\"h\":1128,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":510,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":1490267852406157316,\"id_str\":\"1490267852406157316\",\"indices\":[103,126],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/FK5-t0racAQ6Vir.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/FK5-t0racAQ6Vir.jpg\",\"url\":\"https:\\/\\/t.co\\/At94iqMncT\",\"display_url\":\"pic.twitter.com\\/At94iqMncT\",\"expanded_url\":\"https:\\/\\/twitter.com\\/iRis_k_miyu\\/status\\/1490267860283052038\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":1200,\"h\":900,\"resize\":\"fit\"},\"large\":{\"w\":1504,\"h\":1128,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":510,\"resize\":\"fit\"}}}]}},\"quote_count\":1,\"reply_count\":45,\"retweet_count\":498,\"favorite_count\":3116,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/7PzZwap4SK\",\"expanded_url\":\"https:\\/\\/twitter.com\\/i\\/web\\/status\\/1490267860283052038\",\"display_url\":\"twitter.com\\/i\\/web\\/status\\/1\\u2026\",\"indices\":[104,127]}],\"user_mentions\":[],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"ja\"},\"quoted_status_id\":1490235578356363264,\"quoted_status_id_str\":\"1490235578356363264\",\"quoted_status\":{\"created_at\":\"Sun Feb 06 08:07:03 +0000 2022\",\"id\":1490235578356363264,\"id_str\":\"1490235578356363264\",\"text\":\"\\ud83c\\udfc0#\\u8a66\\u5408\\u901f\\u5831 powered by #\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\\ud83c\\udfc0\\n\\n2\\/6(\\u65e5) \\n\\u30cf\\u30fc\\u30d5\\u30bf\\u30a4\\u30e0\\n43 #\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\n31 #\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\\n\\n\\u300ci\\u2606Ris(\\u30a2\\u30a4\\u30ea\\u30b9)\\u300d\\u306e\\u7686\\u3055\\u3093\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u3067\\u76db\\u308a\\u4e0a\\u3052\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u2026 https:\\/\\/t.co\\/7f7qzGRURd\",\"display_text_range\":[0,140],\"source\":\"\\u003ca href=\\\"http:\\/\\/wsc-sports.com\\\" rel=\\\"nofollow\\\"\\u003eWSC Sports\\u003c\\/a\\u003e\",\"truncated\":true,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":717542939631595520,\"id_str\":\"717542939631595520\",\"name\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\u26a1\\ufe0f\\u6b21\\u56de\\u30db\\u30fc\\u30e0\\u6226 2\\/12,13 vs\\u7fa4\\u99ac @\\u3068\\u3069\\u308d\\u304d\\u30a2\\u30ea\\u30fc\\u30ca\",\"screen_name\":\"brave_thunders\",\"location\":\"\\u795e\\u5948\\u5ddd\\u770c\\u5ddd\\u5d0e\\u5e02\",\"url\":\"http:\\/\\/kawasaki-bravethunders.com\\/\",\"description\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\u516c\\u5f0f\\u3067\\u3059\\u3002\\u300cMAKE THE FUTURE OF BASKETBALL \\u301c\\u5ddd\\u5d0e\\u304b\\u3089\\u30d0\\u30b9\\u30b1\\u306e\\u672a\\u6765\\u3092\\u301c\\u300d \\u5ddd\\u5d0e\\u5e02\\u3092\\u30db\\u30fc\\u30e0\\u30bf\\u30a6\\u30f3\\u3068\\u3057\\u305fB.LEAGUE B1(1\\u90e8)\\u306b\\u6240\\u5c5e\\u3059\\u308b\\u30d7\\u30ed\\u30d0\\u30b9\\u30b1\\u30c3\\u30c8\\u30dc\\u30fc\\u30eb\\u30af\\u30e9\\u30d6\\u3067\\u3059\\u3002\\u30af\\u30e9\\u30d6\\u3078\\u306e\\u304a\\u554f\\u3044\\u5408\\u308f\\u305b\\u306f\\u3001\\u516c\\u5f0fWEB\\u30b5\\u30a4\\u30c8\\u306e\\u5c02\\u7528\\u30d5\\u30a9\\u30fc\\u30e0\\u3092\\u3054\\u5229\\u7528\\u304f\\u3060\\u3055\\u3044\\u3002\",\"translator_type\":\"none\",\"protected\":false,\"verified\":true,\"followers_count\":75891,\"friends_count\":203,\"listed_count\":638,\"favourites_count\":10683,\"statuses_count\":26237,\"created_at\":\"Wed Apr 06 02:42:22 +0000 2016\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"8F0038\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1278126934308737024\\/4zMn_nYk_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1278126934308737024\\/4zMn_nYk_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/717542939631595520\\/1632554071\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"withheld_in_countries\":[]},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"extended_tweet\":{\"full_text\":\"\\ud83c\\udfc0#\\u8a66\\u5408\\u901f\\u5831 powered by #\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\\ud83c\\udfc0\\n\\n2\\/6(\\u65e5) \\n\\u30cf\\u30fc\\u30d5\\u30bf\\u30a4\\u30e0\\n43 #\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\\n31 #\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\\n\\n\\u300ci\\u2606Ris(\\u30a2\\u30a4\\u30ea\\u30b9)\\u300d\\u306e\\u7686\\u3055\\u3093\\u306e\\u30d1\\u30d5\\u30a9\\u30fc\\u30de\\u30f3\\u30b9\\u3067\\u76db\\u308a\\u4e0a\\u3052\\u3066\\u3044\\u305f\\u3060\\u304d\\u307e\\u3057\\u305f\\u2728\\n@iris_official_ #i_Ris\\n\\n#\\u30d0\\u30b9\\u30b1\\u30c3\\u30c8LIVE \\u3067\\u914d\\u4fe1\\u4e2d\\ud83d\\udcf1\\nhttps:\\/\\/t.co\\/C6HZDwP6P9 https:\\/\\/t.co\\/DlkSjBTfW7\",\"display_text_range\":[0,183],\"entities\":{\"hashtags\":[{\"text\":\"\\u8a66\\u5408\\u901f\\u5831\",\"indices\":[1,6]},{\"text\":\"\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\",\"indices\":[18,30]},{\"text\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\",\"indices\":[51,63]},{\"text\":\"\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\",\"indices\":[67,77]},{\"text\":\"i_Ris\",\"indices\":[135,141]},{\"text\":\"\\u30d0\\u30b9\\u30b1\\u30c3\\u30c8LIVE\",\"indices\":[143,153]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/C6HZDwP6P9\",\"expanded_url\":\"https:\\/\\/basketball.mb.softbank.jp\\/lives\\/7799?utm_source=club&utm_medium=kawasaki-bravethunders&utm_campaign=077\",\"display_url\":\"basketball.mb.softbank.jp\\/lives\\/7799?utm\\u2026\",\"indices\":[160,183]}],\"user_mentions\":[{\"screen_name\":\"iris_official_\",\"name\":\"i\\u2606Ris\",\"id\":779723154,\"id_str\":\"779723154\",\"indices\":[119,134]}],\"symbols\":[],\"media\":[{\"id\":1490235470416015361,\"id_str\":\"1490235470416015361\",\"indices\":[184,207],\"additional_media_info\":{\"monetizable\":false},\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"url\":\"https:\\/\\/t.co\\/DlkSjBTfW7\",\"display_url\":\"pic.twitter.com\\/DlkSjBTfW7\",\"expanded_url\":\"https:\\/\\/twitter.com\\/brave_thunders\\/status\\/1490235578356363264\\/video\\/1\",\"type\":\"video\",\"video_info\":{\"aspect_ratio\":[16,9],\"duration_millis\":41700,\"variants\":[{\"content_type\":\"application\\/x-mpegURL\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/pl\\/m7jBiC_ht7UgmQNs.m3u8?tag=14&container=fmp4\"},{\"bitrate\":288000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/480x270\\/iiYxJeCU39rN0Zwm.mp4?tag=14\"},{\"bitrate\":832000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/640x360\\/DylfH3yoZJT_dyY_.mp4?tag=14\"},{\"bitrate\":2176000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/1280x720\\/3VtjS0uKoHaDt0pg.mp4?tag=14\"}]},\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1920,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":675,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":383,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":1490235470416015361,\"id_str\":\"1490235470416015361\",\"indices\":[184,207],\"additional_media_info\":{\"monetizable\":false},\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/FK5hQ0dVcAMpcjo.jpg\",\"url\":\"https:\\/\\/t.co\\/DlkSjBTfW7\",\"display_url\":\"pic.twitter.com\\/DlkSjBTfW7\",\"expanded_url\":\"https:\\/\\/twitter.com\\/brave_thunders\\/status\\/1490235578356363264\\/video\\/1\",\"type\":\"video\",\"video_info\":{\"aspect_ratio\":[16,9],\"duration_millis\":41700,\"variants\":[{\"content_type\":\"application\\/x-mpegURL\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/pl\\/m7jBiC_ht7UgmQNs.m3u8?tag=14&container=fmp4\"},{\"bitrate\":288000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/480x270\\/iiYxJeCU39rN0Zwm.mp4?tag=14\"},{\"bitrate\":832000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/640x360\\/DylfH3yoZJT_dyY_.mp4?tag=14\"},{\"bitrate\":2176000,\"content_type\":\"video\\/mp4\",\"url\":\"https:\\/\\/video.twimg.com\\/amplify_video\\/1490235470416015361\\/vid\\/1280x720\\/3VtjS0uKoHaDt0pg.mp4?tag=14\"}]},\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1920,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":675,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":383,\"resize\":\"fit\"}}}]}},\"quote_count\":78,\"reply_count\":1,\"retweet_count\":795,\"favorite_count\":1828,\"entities\":{\"hashtags\":[{\"text\":\"\\u8a66\\u5408\\u901f\\u5831\",\"indices\":[1,6]},{\"text\":\"\\u30ea\\u30af\\u30eb\\u30fc\\u30c8\\u30a8\\u30fc\\u30b8\\u30a7\\u30f3\\u30c8\",\"indices\":[18,30]},{\"text\":\"\\u5ddd\\u5d0e\\u30d6\\u30ec\\u30a4\\u30d6\\u30b5\\u30f3\\u30c0\\u30fc\\u30b9\",\"indices\":[51,63]},{\"text\":\"\\u30b5\\u30f3\\u30ed\\u30c3\\u30ab\\u30fc\\u30ba\\u6e0b\\u8c37\",\"indices\":[67,77]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/7f7qzGRURd\",\"expanded_url\":\"https:\\/\\/twitter.com\\/i\\/web\\/status\\/1490235578356363264\",\"display_url\":\"twitter.com\\/i\\/web\\/status\\/1\\u2026\",\"indices\":[117,140]}],\"user_mentions\":[],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"ja\"},\"quoted_status_permalink\":{\"url\":\"https:\\/\\/t.co\\/hU0h2HA0ig\",\"expanded\":\"https:\\/\\/twitter.com\\/brave_thunders\\/status\\/1490235578356363264\",\"display\":\"twitter.com\\/brave_thunders\\u2026\"},\"is_quote_status\":true,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[{\"screen_name\":\"iRis_k_miyu\",\"name\":\"\\u4e45\\u4fdd\\u7530\\u672a\\u5922(i\\u2606Ris)\",\"id\":2384783184,\"id_str\":\"2384783184\",\"indices\":[3,15]}],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"ja\",\"timestamp_ms\":\"1644152115160\"}";

        TweetParser tweetParser = new TweetParser();
        Tweet parsedTweet1 = tweetParser.parseTweetWrapper(tweet1);
        System.out.println("parsedTweet1 = " + parsedTweet1);
        assertEquals("Rem", parsedTweet1.getUser().getName());

        Tweet parsedTweet2 = tweetParser.parseTweetWrapper(tweet2);
        System.out.println("parsedTweet2 = " + parsedTweet2);

        assertEquals("ja", parsedTweet2.getLang());
    }

    @Test
    void parseCreatedAtTime() throws ParseException {
        String createdAt = "Sun Feb 06 12:55:16 +0000 2022";
        String twitterDatePattern = "EEE MMM dd HH:mm:ss ZZZZ yyyy";

        SimpleDateFormat sf = new SimpleDateFormat(twitterDatePattern);
        Date d = sf.parse(createdAt);

        System.out.println("date = " + d);
        assertEquals(14, d.getHours());
        assertEquals(6, d.getDate());

//        LocalDate localDate = LocalDate.parse(new SimpleDateFormat(twitterDatePattern, Locale.getDefault()).format(createdAt));
//        LocalDate localDate = LocalDate.parse(sf.format(createdAt));
//        System.out.println("localDate = " + localDate);
    }
}