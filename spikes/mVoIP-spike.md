# mVoIP Feature
#### 개요

VoIP 기능 개발에 대해서 조사합니다.

#### 조사 내용

보이스톡을 참고하여 음성 통화 서비스 (VoIP) 를 구현할 때 사용되는 프로토콜 및 간단 설명합니다.


1. WebRTC (Web Real-Time Communication): WebRTC는 브라우저 및 모바일 애플리케이션에서 실시간 음성 및 비디오 통화를 구현하는 데 사용됩니다. WebRTC는 P2P 통신 및 브라우저 통합을 위해 중요한 역할을 합니다.

2. SRTP (Secure Real-time Transport Protocol): SRTP는 RTP와 함께 사용하여 음성 및 비디오 데이터의 보안을 제공합니다. 사용자 데이터의 보호가 중요하므로 SRTP를 통해 음성 통화의 보안을 강화할 수 있습니다.
RTP (Real-time Transport Protocol): RTP는 음성 및 비디오 데이터의 실시간 전송을 담당하는 프로토콜입니다. RTP는 음성 스트림을 패킷화하고 네트워크를 통해 전송하여 음성 통화의 품질을 관리합니다.

#### WebRTC

* open source project, google에서 관리, W3C, IETF 공식 표준 프로토콜
* web browser, ios, android 플랫폼 지원
* peer to peer 통신 지원
* 오디오, 비디오 데이터 스트림 지원
* 실시간 통신에 적합
* 보안 
* 암호화 (SRTP)
* 피어 인증
* TRUN 서버를 통한 중계
* 네트워크 감지 및 조절을 통한 품질 향상 지원

#### VoIP 서비스 개발 관련
#서버 사이드 (java, js, python 미정)
* 기존서버에는 VoIP을 지원하는 로직이 없기 때문에 신규 개발이 필요함
* 새로운 서버를 구축해야 한다면 어떤 기능을 하는 서버가 필요할까?
  * 시그널링 서버의 역할 필요
    * 통화 가능 여부 확인
    * 통화 요청, 수락, 거부, 종료 처리
  * TURN (Traversal Using Relays around NAT) 서버의 역할 필요
  * 동적 IP, 방화벽, NAT (여러 디바이스가 하나의 공인 IP주소를 가지게 허용하는 기술) 등의 이유로 클라이언트간 Peer to Peer 연결이 어려울 때 보조해 주는 역할이 필요
  * 간단히 Peer - Server - Peer의 네트워크 연결 및 데이터 전송을 중개
* 직접 서버 구현이 나을까 아니면 비용을 지불하고 서비스 벤더를 사용하는게 나을까? (비용, 개발기간 및 난이도)


#클라이언트 사이드 (flutter)
* 어떤 package로 VoIP 클라이언트를 구현할 수 있을까?
    * `flutter_voip_kit package (android, IOS 지원) https://pub.dev/packages/flutter_voip_kit`


#### 더 알아봐야할 부분
* 음성 통화 서비스 제공시 준수해야할 국내 법률 및 규약 
*  VoIP 직접 개발 vs 서비스 이용
*  flutter voip package의 완성도 및 안정성, 지원성 확인 - 미흡하거나 원하는 기능이 없을 때 native로 구현
