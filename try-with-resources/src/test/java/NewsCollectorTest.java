import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.when;

/**
 * Created by Daniel Copaciu on 8/11/2016.
 * dani.copaciu@gmail.com
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsCollectorTest {

    private static final String RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":6963,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":697,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"membership/2016/jun/28/brexit-livestream-what-happens-next-eu-referendum\",\"type\":\"article\",\"sectionId\":\"membership\",\"sectionName\":\"Membership\",\"webPublicationDate\":\"2016-06-28T13:59:04Z\",\"webTitle\":\"Guardian Brexit debate livestream: what happens next?\",\"webUrl\":\"https://www.theguardian.com/membership/2016/jun/28/brexit-livestream-what-happens-next-eu-referendum\",\"apiUrl\":\"https://content.guardianapis.com/membership/2016/jun/28/brexit-livestream-what-happens-next-eu-referendum\",\"isHosted\":false},{\"id\":\"politics/2016/jun/23/digested-eu-referendum-campaign\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-06-23T06:00:03Z\",\"webTitle\":\"The digested referendum campaign: Immigration! Economy! Immigration!\",\"webUrl\":\"https://www.theguardian.com/politics/2016/jun/23/digested-eu-referendum-campaign\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/jun/23/digested-eu-referendum-campaign\",\"isHosted\":false},{\"id\":\"politics/2016/jun/22/the-uk-economy-will-perform-better-outside-the-eu\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-06-22T18:41:57Z\",\"webTitle\":\"The UK economy will perform better outside the EU | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2016/jun/22/the-uk-economy-will-perform-better-outside-the-eu\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/jun/22/the-uk-economy-will-perform-better-outside-the-eu\",\"isHosted\":false},{\"id\":\"politics/2016/aug/09/brexit-weekly-briefing-banks-stimulus-comes-too-soon-for-some\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-08-09T08:56:09Z\",\"webTitle\":\"Brexit weekly briefing: economy takes centre stage as politics stalls\",\"webUrl\":\"https://www.theguardian.com/politics/2016/aug/09/brexit-weekly-briefing-banks-stimulus-comes-too-soon-for-some\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/aug/09/brexit-weekly-briefing-banks-stimulus-comes-too-soon-for-some\",\"isHosted\":false},{\"id\":\"business/2016/apr/03/uk-free-market-economy-isnt-working\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2016-04-03T10:26:45Z\",\"webTitle\":\"Britain's free market economy isn't working\",\"webUrl\":\"https://www.theguardian.com/business/2016/apr/03/uk-free-market-economy-isnt-working\",\"apiUrl\":\"https://content.guardianapis.com/business/2016/apr/03/uk-free-market-economy-isnt-working\",\"isHosted\":false},{\"id\":\"politics/2016/feb/17/brexit-benefits-neil-woodford-fund-manager-capital-economics-report\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2016-02-17T19:40:59Z\",\"webTitle\":\"Brexit could benefit UK economy, says £8bn fund manager\",\"webUrl\":\"https://www.theguardian.com/politics/2016/feb/17/brexit-benefits-neil-woodford-fund-manager-capital-economics-report\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/feb/17/brexit-benefits-neil-woodford-fund-manager-capital-economics-report\",\"isHosted\":false},{\"id\":\"commentisfree/live/2016/aug/11/should-our-rail-services-be-renationalised-live-debate\",\"type\":\"liveblog\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2016-08-11T12:55:32Z\",\"webTitle\":\"Should our rail services be renationalised? Readers' debate\",\"webUrl\":\"https://www.theguardian.com/commentisfree/live/2016/aug/11/should-our-rail-services-be-renationalised-live-debate\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/live/2016/aug/11/should-our-rail-services-be-renationalised-live-debate\",\"isHosted\":false},{\"id\":\"politics/2016/apr/06/us-and-them-narrative-distorts-eu-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-04-06T18:13:13Z\",\"webTitle\":\"‘Us and them’ narrative distorts EU debate | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2016/apr/06/us-and-them-narrative-distorts-eu-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/apr/06/us-and-them-narrative-distorts-eu-debate\",\"isHosted\":false},{\"id\":\"business/2016/mar/02/brexit-damage-uk-economy-blackrock\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2016-03-02T15:27:58Z\",\"webTitle\":\"Brexit would damage UK economy, warns BlackRock\",\"webUrl\":\"https://www.theguardian.com/business/2016/mar/02/brexit-damage-uk-economy-blackrock\",\"apiUrl\":\"https://content.guardianapis.com/business/2016/mar/02/brexit-damage-uk-economy-blackrock\",\"isHosted\":false},{\"id\":\"politics/blog/live/2016/jun/07/eu-referendum-tv-debate-cameron-farage-face-brexit-grilling-live\",\"type\":\"liveblog\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-06-07T22:37:25Z\",\"webTitle\":\"EU referendum TV debate: Farage rejects archbishop's racism claims\",\"webUrl\":\"https://www.theguardian.com/politics/blog/live/2016/jun/07/eu-referendum-tv-debate-cameron-farage-face-brexit-grilling-live\",\"apiUrl\":\"https://content.guardianapis.com/politics/blog/live/2016/jun/07/eu-referendum-tv-debate-cameron-farage-face-brexit-grilling-live\",\"isHosted\":false}]}}";

    @Mock
    private NewsHttpClient newsHttpClient;

    private NewsCollector newsCollector;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        when(newsHttpClient.getNews(anyMap())).thenReturn(RESPONSE);

        newsCollector = new NewsCollector(newsHttpClient);
    }

    @Test
    public void testWriteNewsToFile() throws IOException {
        newsCollector.writeNewsToFile();
        byte[] encoded = Files.readAllBytes(Paths.get("news.txt"));
        assertEquals(new String(encoded), RESPONSE);
    }

}
