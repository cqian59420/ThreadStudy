package grpc;


public class GrpcTest {


    public static void main(String[] args) {
        Message.SearchRequest.Builder searchRequest = Message.SearchRequest.newBuilder();
        searchRequest.setQuery("Terrance");
        searchRequest.setVal(0, 1);
        searchRequest.setVal(0, 2);

    }
}
