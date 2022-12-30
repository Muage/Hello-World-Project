// 컴포넌트 이름은 항상 대문자로 시작

// 함수 컴포넌트
function Welcome(props) {
    return <h1>안녕, {props.name}</h1>;
}

// 클래스 컴포넌트
class Welcome extends React.Component {
    render() {
        return <h1>안녕, {this.props.name}</h1>;
    }
}

const element = <Welcome name="홍길동" />;
ReactDOM.render(
    element,
    document.getElementById('root')
)