import React, { useRef, useState } from 'react'
import { Button, Form, InputGroup, Row, Table } from 'react-bootstrap';
import CheckListItem from './CheckListItem';

const CheckList = () => {

    const nextId = useRef(14);

    const [checkList, setcheckList] = useState([
        { id: 1, contents: "모자", checked: false },
        { id: 2, contents: "워머", checked: false },
        { id: 3, contents: "내의", checked: false },
        { id: 4, contents: "장갑", checked: false },
        { id: 5, contents: "속옷", checked: false },
        { id: 6, contents: "양말", checked: false },
        { id: 7, contents: "고글", checked: false },
        { id: 8, contents: "보호대", checked: false },
        { id: 9, contents: "마스크", checked: false },
        { id: 10, contents: "핫팻", checked: false },
        { id: 11, contents: "휴지", checked: false },
        { id: 12, contents: "500원 4개", checked: false },
        { id: 13, contents: "상비약", checked: false },
    ]);

    const [newContents, setNewContents] = useState("");

    const onClickInsert = () => {
        const newCheckList = {
            id: nextId.current,
            contents: newContents,
            checked: false
        };
        nextId.current = nextId.current + 1;
        setNewContents("");
        setcheckList(checkList.concat(newCheckList));
    }
    
    const onKeyDown = (e) => {
        if(e.key === 'Enter') onClickInsert();
    }

    const onClickDelete = (id) => {
        if(!window.confirm(`${id}번 내용을 삭제하시겠습니까?`)) return;
        setcheckList(checkList.filter(contents => contents.id !== id));
    }

    const onToggle = (id) => {
        const newCheckList = checkList.map(checkList =>
            id === checkList.id ?
            {...checkList, checked: !checkList.checked} :
            checkList
        );
        setcheckList(newCheckList);
    };

    return (
        <Row className="my-3 col-md-3 mx-auto">
            <Row className="my-3">
                <InputGroup>
                    <Form.Control
                            type="text"
                            value={newContents}
                            placeholder="항목 추가"
                            onChange={(e) => setNewContents(e.target.value)}
                            onKeyDown={onKeyDown}/>
                    <Button
                            type="submit"
                            variant="outline-primary"
                            onClick={onClickInsert}>
                        +
                    </Button>
                </InputGroup>
            </Row>
            <Table hover>
                <tbody>
                    {checkList.map(contents =>
                        <CheckListItem
                                key={contents.id}
                                contentsList={contents}
                                onClickDelete={onClickDelete}
                                onToggle={onToggle} />
                    )}
                </tbody>
            </Table>
        </Row>
    )

}

export default CheckList