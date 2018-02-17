package sample.com.codingassignment;

import android.content.Context;

import com.android.volley.VolleyError;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by sharathkaribasappa on 17/02/18.
 *
 * shadow class to mock the network requests
 */

@Implements(VolleyRequest.class)
public class ShadowVolleyRequest {

    @Implementation
    public void initializeRequestQueue(Context context) {}

    @Implementation
    public void performNetworkRequest(String url, final NetworkResponse responseCallBack) {
        if(url.equals(Constants.URL)){
            String response = "{\n" +
                    "\t\"title\": \"About Canada\",\n" +
                    "\t\"rows\": [{\n" +
                    "\t\t\t\"title\": \"Beavers\",\n" +
                    "\t\t\t\"description\": \"Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony\",\n" +
                    "\t\t\t\"imageHref\": \"http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Flag\",\n" +
                    "\t\t\t\"description\": null,\n" +
                    "\t\t\t\"imageHref\": \"http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Transportation\",\n" +
                    "\t\t\t\"description\": \"It is a well known fact that polar bears are the main mode of transportation in Canada. They consume far less gas and have the added benefit of being difficult to steal.\",\n" +
                    "\t\t\t\"imageHref\": \"http://1.bp.blogspot.com/_VZVOmYVm68Q/SMkzZzkGXKI/AAAAAAAAADQ/U89miaCkcyo/s400/the_golden_compass_still.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Hockey Night in Canada\",\n" +
                    "\t\t\t\"description\": \"These Saturday night CBC broadcasts originally aired on radio in 1931. In 1952 they debuted on television and continue to unite (and divide) the nation each week.\",\n" +
                    "\t\t\t\"imageHref\": \"http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Eh\",\n" +
                    "\t\t\t\"description\": \"A chiefly Canadian interrogative utterance, usually expressing surprise or doubt or seeking confirmation.\",\n" +
                    "\t\t\t\"imageHref\": null\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Housing\",\n" +
                    "\t\t\t\"description\": \"Warmer than you might think.\",\n" +
                    "\t\t\t\"imageHref\": \"http://icons.iconarchive.com/icons/iconshock/alaska/256/Igloo-icon.png\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Public Shame\",\n" +
                    "\t\t\t\"description\": \" Sadly it's true.\",\n" +
                    "\t\t\t\"imageHref\": \"http://static.guim.co.uk/sys-images/Music/Pix/site_furniture/2007/04/19/avril_lavigne.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": null,\n" +
                    "\t\t\t\"description\": null,\n" +
                    "\t\t\t\"imageHref\": null\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Space Program\",\n" +
                    "\t\t\t\"description\": \"Canada hopes to soon launch a man to the moon.\",\n" +
                    "\t\t\t\"imageHref\": \"http://files.turbosquid.com/Preview/Content_2009_07_14__10_25_15/trebucheta.jpgdf3f3bf4-935d-40ff-84b2-6ce718a327a9Larger.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Meese\",\n" +
                    "\t\t\t\"description\": \"A moose is a common sight in Canada. Tall and majestic, they represent many of the values which Canadians imagine that they possess. They grow up to 2.7 metres long and can weigh over 700 kg. They swim at 10 km/h. Moose antlers weigh roughly 20 kg. The plural of moose is actually 'meese', despite what most dictionaries, encyclopedias, and experts will tell you.\",\n" +
                    "\t\t\t\"imageHref\": \"http://caroldeckerwildlifeartstudio.net/wp-content/uploads/2011/04/IMG_2418%20majestic%20moose%201%20copy%20(Small)-96x96.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Geography\",\n" +
                    "\t\t\t\"description\": \"It's really big.\",\n" +
                    "\t\t\t\"imageHref\": null\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Kittens...\",\n" +
                    "\t\t\t\"description\": \"Éare illegal. Cats are fine.\",\n" +
                    "\t\t\t\"imageHref\": \"http://www.donegalhimalayans.com/images/That%20fish%20was%20this%20big.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Mounties\",\n" +
                    "\t\t\t\"description\": \"They are the law. They are also Canada's foreign espionage service. Subtle.\",\n" +
                    "\t\t\t\"imageHref\": \"http://3.bp.blogspot.com/__mokxbTmuJM/RnWuJ6cE9cI/AAAAAAAAATw/6z3m3w9JDiU/s400/019843_31.jpg\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"title\": \"Language\",\n" +
                    "\t\t\t\"description\": \"Nous parlons tous les langues importants.\",\n" +
                    "\t\t\t\"imageHref\": null\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}";
            responseCallBack.onSuccessResponse(response);
        } else if(url.equals("error")) {
            VolleyError error = new VolleyError();
            responseCallBack.onErrorResponse(error);
        } else if (url.equals("noNetwork")){
            responseCallBack.onNoNetwork();
        }
    }
}
