import React from 'react';
import { Alert, Container, Nav, Navbar, Row } from 'react-bootstrap';
import { Link, Route, Switch } from 'react-router-dom';
import CheckList from './CheckList';
import ExpectedCost from './ExpectedCost';
import SkiResortList from './SkiResortList';

const Wrapper = () => {

    return (
        <div>
            <Navbar bg="primary" variant="dark">
                <Container>
                <Nav className="m-auto" defaultActiveKey="#skiResortList">
                    <Nav.Link
                            as={Link}
                            className="mx-5"
                            href='#skiResortList'
                            to='/'>
                        스키장 전체보기
                    </Nav.Link>
                    <Nav.Link
                            as={Link}
                            className="mx-5"
                            href="#cost"
                            to='/cost'>
                        예상 비용 계산
                    </Nav.Link>
                    <Nav.Link
                            as={Link}
                            className="mx-5"
                            href="#checkList"
                            to='/checkList'>
                        체크리스트
                    </Nav.Link>
                </Nav>
                </Container>
            </Navbar>

            <Switch>
                <Route exact path='/' component={SkiResortList} />
                <Route exact path='/cost' component={ExpectedCost} />
                <Route exact path='/checklist' component={CheckList} />
            </Switch>

            <Row>
                <Alert variant="secondary" style={{ width: "100%", textAlign: "center" }}>
                    본 페이지는 공식 홈페이지를 기반으로 제작되었습니다.
                    주변 렌탈샵을 이용하시면 보다 저렴하게 이용하실 수도 있습니다.
                </Alert>
            </Row>
        </div>
    );

}

export default Wrapper;