import React from 'react';
import { Button, Modal, Tab, Tabs } from 'react-bootstrap';
import SkiResortLocation from './SkiResortLocation';
import SkiResortPicture from './SkiResortPicture';

function SkiResortItem({ skiResort }) {

    const { name, tel, link, address, direction, x, y, distance, estimatedTime, image } = skiResort;

    // 예상소요시간
    var estimatedTimeHour = parseInt(estimatedTime / 60);
    var estimatedTimeMinute = parseInt(estimatedTime % 60);

    // 스키장 정보 모달
    function SkiResortInformationModal(props) {
        return (
            <Modal
                {...props}
                size="lg"
                aria-labelledby="contained-modal-title-vcenter"
                centered>
                <Modal.Header closeButton>
                    <Modal.Title id="contained-modal-title-vcenter">
                        {name}
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body style={{ paddingBottom: 0 }}>
                    <Tabs
                            defaultActiveKey="skiResortLocation"
                            id="justify-tab-example"
                            justify>
                        <Tab
                                eventKey="skiResortLocation"
                                title="정보">
                            <SkiResortLocation
                                    tel={tel}
                                    link={link}
                                    address={address}
                                    direction={direction}
                                    x={x}
                                    y={y} />
                        </Tab>
                        <Tab
                                eventKey="skiResortPicture"
                                title="사진">
                            <SkiResortPicture image={image} />
                        </Tab>
                    </Tabs>
                </Modal.Body>
                <Modal.Footer>
                    <Button onClick={props.onHide}>Close</Button>
                </Modal.Footer>
            </Modal>
        );
    }
    const [modalShow, setModalShow] = React.useState(false);

    return (
        <tr>
            <td className="align-middle">{name}</td>
            <td className="align-middle">{address}</td>
            <td className="align-middle text-center"><b>{distance}</b>km</td>
            <td className="align-middle text-center">{estimatedTimeHour}시간 {estimatedTimeMinute}분</td>
            <td className="text-center">
                <Button
                        variant="outline-secondary"
                        onClick={() => setModalShow(true)}>
                    정보
                </Button>
                {/* 스키장 정보 모달 */}
                <SkiResortInformationModal
                        show={modalShow}
                        onHide={() => setModalShow(false)} />
            </td>
        </tr>
    );

}

export default SkiResortItem;