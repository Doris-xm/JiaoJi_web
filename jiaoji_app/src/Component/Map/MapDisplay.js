import React, { useEffect } from 'react';
import AMapLoader from '@amap/amap-jsapi-loader';

class MapDisplay extends React.Component {
    constructor(props) {
        super(props);
        this.mapContainerRef = React.createRef();
        this.map = null;
        this.marker = null;
    }

    componentDidMount() {
        AMapLoader.load({
            key: 'b02cb7d4c643c215c9745d5f94eba632',
            version: '2.0',
            plugins: [],
        })
            .then((AMap) => {
                this.initMap(AMap);
            })
            .catch((error) => {
                console.log(error);
            });
    }


    initMap = (AMap) => {
        const { latitude, longitude, name } = this.props;
        this.map = new AMap.Map(this.mapContainerRef.current, {
            resizeEnable: true,
            center: [longitude, latitude],
            zoom: 15,
        });
        // 增加地点标记
        this.marker = new AMap.Marker({
            position: [longitude, latitude],
            map: this.map,
        });
        this.infoWindow = new AMap.InfoWindow({
            content: `<h3>${name}</h3>`,
        });
        this.marker.on('click', () => {
            this.infoWindow.open(this.map, this.marker.getPosition());
        });

    };

    updateMarkerPosition = () => {
        const { latitude, longitude } = this.props;
        this.marker.setPosition([longitude, latitude]);
        this.map.setCenter([longitude, latitude]);
    };

    render() {
        return <div ref={this.mapContainerRef} style={{ width: '100%', height: '300px' }}></div>;
    }
}

export default MapDisplay;
