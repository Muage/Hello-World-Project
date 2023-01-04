import Card from "./Card";

function ProfileCard(props) {

    return (
        <Card
                title="Hello World"
                backgroundColor="green">
            <p>안녕하세요.</p>
            <p>리액트 연습중입니다.</p>
        </Card>
    );

}

export default ProfileCard;