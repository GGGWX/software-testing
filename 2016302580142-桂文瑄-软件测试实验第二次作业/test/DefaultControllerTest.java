

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * DefaultController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 10, 2019</pre>
 */
public class DefaultControllerTest {

    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    @Before
    public void before() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();

        controller.addHandler(request, handler);
    }

    @Test
    public void testAddHandler() {
        //TODO 验证实例化测试对象handler被成功的注册到controller上
        assertEquals(handler, controller.getHandler(request));
    }



    @Test
    public void testProcessRequest() {
        //TODO 验证processRequest()方法返回的Response对象不是null，注意提供解释失败的原因
        //TODO 验证返回的response是SampleResponse类型
        Response res = controller.processRequest(request);
        assertNotNull("response is null", res);
        assertTrue(res instanceof SampleResponse);
    }

    @Test
    public void testProcessRequestAnswersErrorResponse() {//测试异常处理
        //TODO 为request对象注册一个SampleExceptionHandler，模拟Handler处理信息时抛出异常的情况
        //TODO 验证错误条件下的processRequest()返回的response对象不为NULL
        //TODO 验证返回的response对象是ErrorResponse类型
        Request new_request = new SampleRequest("New Test");
        SampleExceptionHandler sampleExceptionHandler = new SampleExceptionHandler();
        controller.addHandler(new_request, sampleExceptionHandler);
        Response res = controller.processRequest(new_request);
        assertNotNull("processRequest() return not null", res);
        assertTrue(res instanceof ErrorResponse);
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        //TODO 验证未注册的request对象会抛出RuntimeException异常
        Request res = new SampleRequest("Test2");
        controller.addHandler(res, handler);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() {
        //TODO 验证注册重名请求时会抛出RuntimeException异常
        SampleResponse sampleResponse = new SampleResponse("Test");
    }


    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Test";

        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        public String getName() {
            return this.name;
        }
    }

    private class SampleExceptionHandler implements RequestHandler {
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }

    private class SampleResponse implements Response {
        private static final String DEFAULT_NAME = "Test";

        private String name;

        public String getName() {
            return this.name;
        }

        public SampleResponse(String name) {
            this.name = name;
        }

        public SampleResponse() {
            this(DEFAULT_NAME);
        }

        public boolean equals(Object object) {//用来验证返回的Response对象的类型
            boolean result = false;
            if (object instanceof SampleResponse) {
                result = ((SampleResponse) object).getName().equals(getName());
            }
            return result;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    private class SampleHandler implements RequestHandler {
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

}
