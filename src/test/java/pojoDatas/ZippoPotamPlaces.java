package pojoDatas;

public class ZippoPotamPlaces {
     /*
     {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [{
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
            }]
    }
     */
    /*
    POJO: Plain Old Java Object
    Expected Data veya Actual Dataları depolamak için yani tutmak için kullanıyoruz.

    1)Fieldlar ----> Var.     PRIVATE   -------> Her bir json için
    2)Parametresiz Constructor
    3)Parametreli Constructor
    4)Gettter and Setter
    5) toString()
     */
    private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;
}
