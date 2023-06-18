import React from 'react';
import AMapLoader from '@amap/amap-jsapi-loader';
import {Form, Input} from "antd";

class MapSearch extends React.Component {
    constructor(props) {
        super(props);
        this.mapContainerRef = React.createRef();
        this.inputRef = React.createRef();
        this.map = null;
        this.placeSearch = null;
    }

    componentDidMount() {
        AMapLoader.load({
            key: 'b02cb7d4c643c215c9745d5f94eba632',
            version: '2.0',
            plugins: ['AMap.PlaceSearch'],
        })
            .then((AMap) => {
                this.initMap(AMap);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    initMap = (AMap) => {
        this.map = new AMap.Map(this.mapContainerRef.current, {
            resizeEnable: true,
            center: [121.442242, 31.022307],
            zoom: 15,
        });
        this.placeSearch = new AMap.PlaceSearch({
            map: this.map,
            autoFitView: true,
            pageSize: 5,
        });
        this.placeSearch.on('markerClick', (e) => {
            const {selectAddress} = this.props;
            // console.log(e);
            selectAddress({
                name: e.data.name,
                lng: e.data.location.lng,
                lat: e.data.location.lat,
            });
        });
    };

    handleSearch = () => {
        const keyword = this.inputRef.current.value;
        this.placeSearch.search(keyword);
    };

    render() {
        return (
            <div>
                <div ref={this.mapContainerRef} id="container" style={{ width: '95%', height: '300px' }}></div>
                <div id="myPageTop">
                    <table>
                        <tr>
                            <td>
                                <label>请输入地点：</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input ref={this.inputRef} id="tipinput" />
                            </td>
                            <td>
                                <button onClick={this.handleSearch}>搜索</button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        );
    }
}

export default MapSearch;
